package net.mcreator.fireforce;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class FireforceModVariables {
	public FireforceModVariables(FireforceModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("fireforce", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putBoolean("voltagenovaactive", instance.voltagenovaactive);
			nbt.putBoolean("pressofdeath", instance.pressofdeath);
			nbt.putBoolean("joinworldfirsttimestamina", instance.joinworldfirsttimestamina);
			nbt.putBoolean("joinworldfirsttime", instance.joinworldfirsttime);
			nbt.putBoolean("HasAwakened", instance.HasAwakened);
			nbt.putBoolean("firearrowactive", instance.firearrowactive);
			nbt.putBoolean("customeyesactive", instance.customeyesactive);
			nbt.putBoolean("Adollaburst", instance.Adollaburst);
			nbt.putDouble("xpmax", instance.xpmax);
			nbt.putDouble("XP", instance.XP);
			nbt.putDouble("voltagenovastage", instance.voltagenovastage);
			nbt.putDouble("SP", instance.SP);
			nbt.putDouble("secondgenobsorb", instance.secondgenobsorb);
			nbt.putDouble("LVL", instance.LVL);
			nbt.putDouble("IgnitionAbilityTHIRDtype", instance.IgnitionAbilityTHIRDtype);
			nbt.putDouble("IgnitionAbilitySECONDtype", instance.IgnitionAbilitySECONDtype);
			nbt.putDouble("IgnitionAbilityINFERNALtype", instance.IgnitionAbilityINFERNALtype);
			nbt.putDouble("IgnitionAbilityFOURTHtype", instance.IgnitionAbilityFOURTHtype);
			nbt.putDouble("IgnitionAbilityDEMONINFERNALtype", instance.IgnitionAbilityDEMONINFERNALtype);
			nbt.putDouble("heatabsorbed", instance.heatabsorbed);
			nbt.putDouble("Generation", instance.Generation);
			nbt.putDouble("FireSpeed", instance.FireSpeed);
			nbt.putDouble("FireResistancedefense", instance.FireResistancedefense);
			nbt.putDouble("firepowerxp5", instance.firepowerxp5);
			nbt.putDouble("firepowerxp4", instance.firepowerxp4);
			nbt.putDouble("firepowerxp3", instance.firepowerxp3);
			nbt.putDouble("firepowerxp2", instance.firepowerxp2);
			nbt.putDouble("firepowerxp1", instance.firepowerxp1);
			nbt.putDouble("firepowerxp0", instance.firepowerxp0);
			nbt.putDouble("FirePower", instance.FirePower);
			nbt.putDouble("FireOxygenMax", instance.FireOxygenMax);
			nbt.putDouble("FireOxygen", instance.FireOxygen);
			nbt.putDouble("FireOverheatlevel", instance.FireOverheatlevel);
			nbt.putDouble("FireHealth", instance.FireHealth);
			nbt.putDouble("cooldown1", instance.cooldown1);
			nbt.putDouble("adollalburstevel", instance.adollalburstevel);
			nbt.putDouble("abilityunlcoked", instance.abilityunlcoked);
			nbt.putString("PlayerName", instance.PlayerName);
			nbt.putDouble("voltagenovatime", instance.voltagenovatime);
			nbt.putDouble("tickspassed", instance.tickspassed);
			nbt.putDouble("tickspassedforfirexp", instance.tickspassedforfirexp);
			nbt.putDouble("coolsdown2", instance.coolsdown2);
			nbt.putBoolean("novaexpel", instance.novaexpel);
			nbt.putBoolean("abilityunlocked1", instance.abilityunlocked1);
			nbt.putBoolean("abilityunlocked2", instance.abilityunlocked2);
			nbt.putBoolean("abilityunlocked3", instance.abilityunlocked3);
			nbt.putBoolean("abilityunlocked4", instance.abilityunlocked4);
			nbt.putDouble("tickspassedsoundfirestage", instance.tickspassedsoundfirestage);
			nbt.putBoolean("VNscaleup", instance.VNscaleup);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.voltagenovaactive = nbt.getBoolean("voltagenovaactive");
			instance.pressofdeath = nbt.getBoolean("pressofdeath");
			instance.joinworldfirsttimestamina = nbt.getBoolean("joinworldfirsttimestamina");
			instance.joinworldfirsttime = nbt.getBoolean("joinworldfirsttime");
			instance.HasAwakened = nbt.getBoolean("HasAwakened");
			instance.firearrowactive = nbt.getBoolean("firearrowactive");
			instance.customeyesactive = nbt.getBoolean("customeyesactive");
			instance.Adollaburst = nbt.getBoolean("Adollaburst");
			instance.xpmax = nbt.getDouble("xpmax");
			instance.XP = nbt.getDouble("XP");
			instance.voltagenovastage = nbt.getDouble("voltagenovastage");
			instance.SP = nbt.getDouble("SP");
			instance.secondgenobsorb = nbt.getDouble("secondgenobsorb");
			instance.LVL = nbt.getDouble("LVL");
			instance.IgnitionAbilityTHIRDtype = nbt.getDouble("IgnitionAbilityTHIRDtype");
			instance.IgnitionAbilitySECONDtype = nbt.getDouble("IgnitionAbilitySECONDtype");
			instance.IgnitionAbilityINFERNALtype = nbt.getDouble("IgnitionAbilityINFERNALtype");
			instance.IgnitionAbilityFOURTHtype = nbt.getDouble("IgnitionAbilityFOURTHtype");
			instance.IgnitionAbilityDEMONINFERNALtype = nbt.getDouble("IgnitionAbilityDEMONINFERNALtype");
			instance.heatabsorbed = nbt.getDouble("heatabsorbed");
			instance.Generation = nbt.getDouble("Generation");
			instance.FireSpeed = nbt.getDouble("FireSpeed");
			instance.FireResistancedefense = nbt.getDouble("FireResistancedefense");
			instance.firepowerxp5 = nbt.getDouble("firepowerxp5");
			instance.firepowerxp4 = nbt.getDouble("firepowerxp4");
			instance.firepowerxp3 = nbt.getDouble("firepowerxp3");
			instance.firepowerxp2 = nbt.getDouble("firepowerxp2");
			instance.firepowerxp1 = nbt.getDouble("firepowerxp1");
			instance.firepowerxp0 = nbt.getDouble("firepowerxp0");
			instance.FirePower = nbt.getDouble("FirePower");
			instance.FireOxygenMax = nbt.getDouble("FireOxygenMax");
			instance.FireOxygen = nbt.getDouble("FireOxygen");
			instance.FireOverheatlevel = nbt.getDouble("FireOverheatlevel");
			instance.FireHealth = nbt.getDouble("FireHealth");
			instance.cooldown1 = nbt.getDouble("cooldown1");
			instance.adollalburstevel = nbt.getDouble("adollalburstevel");
			instance.abilityunlcoked = nbt.getDouble("abilityunlcoked");
			instance.PlayerName = nbt.getString("PlayerName");
			instance.voltagenovatime = nbt.getDouble("voltagenovatime");
			instance.tickspassed = nbt.getDouble("tickspassed");
			instance.tickspassedforfirexp = nbt.getDouble("tickspassedforfirexp");
			instance.coolsdown2 = nbt.getDouble("coolsdown2");
			instance.novaexpel = nbt.getBoolean("novaexpel");
			instance.abilityunlocked1 = nbt.getBoolean("abilityunlocked1");
			instance.abilityunlocked2 = nbt.getBoolean("abilityunlocked2");
			instance.abilityunlocked3 = nbt.getBoolean("abilityunlocked3");
			instance.abilityunlocked4 = nbt.getBoolean("abilityunlocked4");
			instance.tickspassedsoundfirestage = nbt.getDouble("tickspassedsoundfirestage");
			instance.VNscaleup = nbt.getBoolean("VNscaleup");
		}
	}

	public static class PlayerVariables {
		public boolean voltagenovaactive = false;
		public boolean pressofdeath = false;
		public boolean joinworldfirsttimestamina = false;
		public boolean joinworldfirsttime = false;
		public boolean HasAwakened = false;
		public boolean firearrowactive = false;
		public boolean customeyesactive = false;
		public boolean Adollaburst = false;
		public double xpmax = 0;
		public double XP = 5.0;
		public double voltagenovastage = 0;
		public double SP = 0;
		public double secondgenobsorb = 0;
		public double LVL = 0;
		public double IgnitionAbilityTHIRDtype = 0;
		public double IgnitionAbilitySECONDtype = 0;
		public double IgnitionAbilityINFERNALtype = 0;
		public double IgnitionAbilityFOURTHtype = 0;
		public double IgnitionAbilityDEMONINFERNALtype = 0;
		public double heatabsorbed = 0;
		public double Generation = 0;
		public double FireSpeed = 0;
		public double FireResistancedefense = 0;
		public double firepowerxp5 = 0;
		public double firepowerxp4 = 0;
		public double firepowerxp3 = 0;
		public double firepowerxp2 = 0;
		public double firepowerxp1 = 0;
		public double firepowerxp0 = 0;
		public double FirePower = 0;
		public double FireOxygenMax = 0;
		public double FireOxygen = 0.0;
		public double FireOverheatlevel = 0;
		public double FireHealth = 0;
		public double cooldown1 = 0;
		public double adollalburstevel = 0;
		public double abilityunlcoked = 0;
		public String PlayerName = "";
		public double voltagenovatime = 0;
		public double tickspassed = 0;
		public double tickspassedforfirexp = 0;
		public double coolsdown2 = 0;
		public boolean novaexpel = false;
		public boolean abilityunlocked1 = false;
		public boolean abilityunlocked2 = false;
		public boolean abilityunlocked3 = false;
		public boolean abilityunlocked4 = false;
		public double tickspassedsoundfirestage = 0;
		public boolean VNscaleup = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				FireforceMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.joinworldfirsttimestamina = original.joinworldfirsttimestamina;
		clone.joinworldfirsttime = original.joinworldfirsttime;
		clone.HasAwakened = original.HasAwakened;
		clone.customeyesactive = original.customeyesactive;
		clone.Adollaburst = original.Adollaburst;
		clone.xpmax = original.xpmax;
		clone.XP = original.XP;
		clone.SP = original.SP;
		clone.LVL = original.LVL;
		clone.IgnitionAbilityTHIRDtype = original.IgnitionAbilityTHIRDtype;
		clone.IgnitionAbilitySECONDtype = original.IgnitionAbilitySECONDtype;
		clone.IgnitionAbilityINFERNALtype = original.IgnitionAbilityINFERNALtype;
		clone.IgnitionAbilityFOURTHtype = original.IgnitionAbilityFOURTHtype;
		clone.IgnitionAbilityDEMONINFERNALtype = original.IgnitionAbilityDEMONINFERNALtype;
		clone.Generation = original.Generation;
		clone.FireSpeed = original.FireSpeed;
		clone.FireResistancedefense = original.FireResistancedefense;
		clone.firepowerxp5 = original.firepowerxp5;
		clone.firepowerxp4 = original.firepowerxp4;
		clone.firepowerxp3 = original.firepowerxp3;
		clone.firepowerxp2 = original.firepowerxp2;
		clone.firepowerxp1 = original.firepowerxp1;
		clone.firepowerxp0 = original.firepowerxp0;
		clone.FirePower = original.FirePower;
		clone.FireOxygenMax = original.FireOxygenMax;
		clone.FireHealth = original.FireHealth;
		clone.adollalburstevel = original.adollalburstevel;
		clone.abilityunlcoked = original.abilityunlcoked;
		clone.PlayerName = original.PlayerName;
		clone.voltagenovatime = original.voltagenovatime;
		clone.abilityunlocked1 = original.abilityunlocked1;
		clone.abilityunlocked2 = original.abilityunlocked2;
		clone.abilityunlocked3 = original.abilityunlocked3;
		clone.abilityunlocked4 = original.abilityunlocked4;
		if (!event.isWasDeath()) {
			clone.voltagenovaactive = original.voltagenovaactive;
			clone.pressofdeath = original.pressofdeath;
			clone.firearrowactive = original.firearrowactive;
			clone.voltagenovastage = original.voltagenovastage;
			clone.secondgenobsorb = original.secondgenobsorb;
			clone.heatabsorbed = original.heatabsorbed;
			clone.FireOxygen = original.FireOxygen;
			clone.FireOverheatlevel = original.FireOverheatlevel;
			clone.cooldown1 = original.cooldown1;
			clone.tickspassed = original.tickspassed;
			clone.tickspassedforfirexp = original.tickspassedforfirexp;
			clone.coolsdown2 = original.coolsdown2;
			clone.novaexpel = original.novaexpel;
			clone.tickspassedsoundfirestage = original.tickspassedsoundfirestage;
			clone.VNscaleup = original.VNscaleup;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.voltagenovaactive = message.data.voltagenovaactive;
					variables.pressofdeath = message.data.pressofdeath;
					variables.joinworldfirsttimestamina = message.data.joinworldfirsttimestamina;
					variables.joinworldfirsttime = message.data.joinworldfirsttime;
					variables.HasAwakened = message.data.HasAwakened;
					variables.firearrowactive = message.data.firearrowactive;
					variables.customeyesactive = message.data.customeyesactive;
					variables.Adollaburst = message.data.Adollaburst;
					variables.xpmax = message.data.xpmax;
					variables.XP = message.data.XP;
					variables.voltagenovastage = message.data.voltagenovastage;
					variables.SP = message.data.SP;
					variables.secondgenobsorb = message.data.secondgenobsorb;
					variables.LVL = message.data.LVL;
					variables.IgnitionAbilityTHIRDtype = message.data.IgnitionAbilityTHIRDtype;
					variables.IgnitionAbilitySECONDtype = message.data.IgnitionAbilitySECONDtype;
					variables.IgnitionAbilityINFERNALtype = message.data.IgnitionAbilityINFERNALtype;
					variables.IgnitionAbilityFOURTHtype = message.data.IgnitionAbilityFOURTHtype;
					variables.IgnitionAbilityDEMONINFERNALtype = message.data.IgnitionAbilityDEMONINFERNALtype;
					variables.heatabsorbed = message.data.heatabsorbed;
					variables.Generation = message.data.Generation;
					variables.FireSpeed = message.data.FireSpeed;
					variables.FireResistancedefense = message.data.FireResistancedefense;
					variables.firepowerxp5 = message.data.firepowerxp5;
					variables.firepowerxp4 = message.data.firepowerxp4;
					variables.firepowerxp3 = message.data.firepowerxp3;
					variables.firepowerxp2 = message.data.firepowerxp2;
					variables.firepowerxp1 = message.data.firepowerxp1;
					variables.firepowerxp0 = message.data.firepowerxp0;
					variables.FirePower = message.data.FirePower;
					variables.FireOxygenMax = message.data.FireOxygenMax;
					variables.FireOxygen = message.data.FireOxygen;
					variables.FireOverheatlevel = message.data.FireOverheatlevel;
					variables.FireHealth = message.data.FireHealth;
					variables.cooldown1 = message.data.cooldown1;
					variables.adollalburstevel = message.data.adollalburstevel;
					variables.abilityunlcoked = message.data.abilityunlcoked;
					variables.PlayerName = message.data.PlayerName;
					variables.voltagenovatime = message.data.voltagenovatime;
					variables.tickspassed = message.data.tickspassed;
					variables.tickspassedforfirexp = message.data.tickspassedforfirexp;
					variables.coolsdown2 = message.data.coolsdown2;
					variables.novaexpel = message.data.novaexpel;
					variables.abilityunlocked1 = message.data.abilityunlocked1;
					variables.abilityunlocked2 = message.data.abilityunlocked2;
					variables.abilityunlocked3 = message.data.abilityunlocked3;
					variables.abilityunlocked4 = message.data.abilityunlocked4;
					variables.tickspassedsoundfirestage = message.data.tickspassedsoundfirestage;
					variables.VNscaleup = message.data.VNscaleup;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
