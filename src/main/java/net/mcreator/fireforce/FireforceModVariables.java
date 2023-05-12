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
			nbt.putDouble("XP", instance.XP);
			nbt.putDouble("SP", instance.SP);
			nbt.putString("PlayerName", instance.PlayerName);
			nbt.putDouble("Overheat", instance.Overheat);
			nbt.putDouble("LVL", instance.LVL);
			nbt.putBoolean("joinworldfirsttime", instance.joinworldfirsttime);
			nbt.putDouble("IgnitionAbilityTHIRDtype", instance.IgnitionAbilityTHIRDtype);
			nbt.putDouble("IgnitionAbilitySECONDtype", instance.IgnitionAbilitySECONDtype);
			nbt.putDouble("IgnitionAbilityINFERNALtype", instance.IgnitionAbilityINFERNALtype);
			nbt.putDouble("IgnitionAbilityFOURTHtype", instance.IgnitionAbilityFOURTHtype);
			nbt.putDouble("IgnitionAbilityDEMONINFERNALtype", instance.IgnitionAbilityDEMONINFERNALtype);
			nbt.putDouble("heatabsorbed", instance.heatabsorbed);
			nbt.putBoolean("HasAwakened", instance.HasAwakened);
			nbt.putDouble("Generation", instance.Generation);
			nbt.putDouble("FireSpeed", instance.FireSpeed);
			nbt.putDouble("FireResistancedefense", instance.FireResistancedefense);
			nbt.putDouble("FireResistance", instance.FireResistance);
			nbt.putDouble("FirePower", instance.FirePower);
			nbt.putDouble("FireHealth", instance.FireHealth);
			nbt.putDouble("adollalburstevel", instance.adollalburstevel);
			nbt.putBoolean("Adollaburst", instance.Adollaburst);
			nbt.putDouble("secondgenobsorb", instance.secondgenobsorb);
			nbt.putDouble("FireResistanceMax", instance.FireResistanceMax);
			nbt.putBoolean("joinworldfirsttimestamina", instance.joinworldfirsttimestamina);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.XP = nbt.getDouble("XP");
			instance.SP = nbt.getDouble("SP");
			instance.PlayerName = nbt.getString("PlayerName");
			instance.Overheat = nbt.getDouble("Overheat");
			instance.LVL = nbt.getDouble("LVL");
			instance.joinworldfirsttime = nbt.getBoolean("joinworldfirsttime");
			instance.IgnitionAbilityTHIRDtype = nbt.getDouble("IgnitionAbilityTHIRDtype");
			instance.IgnitionAbilitySECONDtype = nbt.getDouble("IgnitionAbilitySECONDtype");
			instance.IgnitionAbilityINFERNALtype = nbt.getDouble("IgnitionAbilityINFERNALtype");
			instance.IgnitionAbilityFOURTHtype = nbt.getDouble("IgnitionAbilityFOURTHtype");
			instance.IgnitionAbilityDEMONINFERNALtype = nbt.getDouble("IgnitionAbilityDEMONINFERNALtype");
			instance.heatabsorbed = nbt.getDouble("heatabsorbed");
			instance.HasAwakened = nbt.getBoolean("HasAwakened");
			instance.Generation = nbt.getDouble("Generation");
			instance.FireSpeed = nbt.getDouble("FireSpeed");
			instance.FireResistancedefense = nbt.getDouble("FireResistancedefense");
			instance.FireResistance = nbt.getDouble("FireResistance");
			instance.FirePower = nbt.getDouble("FirePower");
			instance.FireHealth = nbt.getDouble("FireHealth");
			instance.adollalburstevel = nbt.getDouble("adollalburstevel");
			instance.Adollaburst = nbt.getBoolean("Adollaburst");
			instance.secondgenobsorb = nbt.getDouble("secondgenobsorb");
			instance.FireResistanceMax = nbt.getDouble("FireResistanceMax");
			instance.joinworldfirsttimestamina = nbt.getBoolean("joinworldfirsttimestamina");
		}
	}

	public static class PlayerVariables {
		public double XP = 0.0;
		public double SP = 0;
		public String PlayerName = "";
		public double Overheat = 0;
		public double LVL = 0;
		public boolean joinworldfirsttime = false;
		public double IgnitionAbilityTHIRDtype = 0;
		public double IgnitionAbilitySECONDtype = 0;
		public double IgnitionAbilityINFERNALtype = 0;
		public double IgnitionAbilityFOURTHtype = 0;
		public double IgnitionAbilityDEMONINFERNALtype = 0;
		public double heatabsorbed = 0;
		public boolean HasAwakened = false;
		public double Generation = 0;
		public double FireSpeed = 0;
		public double FireResistancedefense = 0;
		public double FireResistance = 0.0;
		public double FirePower = 0;
		public double FireHealth = 0;
		public double adollalburstevel = 0;
		public boolean Adollaburst = false;
		public double secondgenobsorb = 0;
		public double FireResistanceMax = 0;
		public boolean joinworldfirsttimestamina = false;

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
		clone.XP = original.XP;
		clone.SP = original.SP;
		clone.PlayerName = original.PlayerName;
		clone.Overheat = original.Overheat;
		clone.LVL = original.LVL;
		clone.joinworldfirsttime = original.joinworldfirsttime;
		clone.IgnitionAbilityTHIRDtype = original.IgnitionAbilityTHIRDtype;
		clone.IgnitionAbilityINFERNALtype = original.IgnitionAbilityINFERNALtype;
		clone.IgnitionAbilityFOURTHtype = original.IgnitionAbilityFOURTHtype;
		clone.IgnitionAbilityDEMONINFERNALtype = original.IgnitionAbilityDEMONINFERNALtype;
		clone.HasAwakened = original.HasAwakened;
		clone.Generation = original.Generation;
		clone.FireSpeed = original.FireSpeed;
		clone.FireResistancedefense = original.FireResistancedefense;
		clone.FireResistance = original.FireResistance;
		clone.FirePower = original.FirePower;
		clone.FireHealth = original.FireHealth;
		clone.Adollaburst = original.Adollaburst;
		clone.FireResistanceMax = original.FireResistanceMax;
		clone.joinworldfirsttimestamina = original.joinworldfirsttimestamina;
		if (!event.isWasDeath()) {
			clone.IgnitionAbilitySECONDtype = original.IgnitionAbilitySECONDtype;
			clone.heatabsorbed = original.heatabsorbed;
			clone.adollalburstevel = original.adollalburstevel;
			clone.secondgenobsorb = original.secondgenobsorb;
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
					variables.XP = message.data.XP;
					variables.SP = message.data.SP;
					variables.PlayerName = message.data.PlayerName;
					variables.Overheat = message.data.Overheat;
					variables.LVL = message.data.LVL;
					variables.joinworldfirsttime = message.data.joinworldfirsttime;
					variables.IgnitionAbilityTHIRDtype = message.data.IgnitionAbilityTHIRDtype;
					variables.IgnitionAbilitySECONDtype = message.data.IgnitionAbilitySECONDtype;
					variables.IgnitionAbilityINFERNALtype = message.data.IgnitionAbilityINFERNALtype;
					variables.IgnitionAbilityFOURTHtype = message.data.IgnitionAbilityFOURTHtype;
					variables.IgnitionAbilityDEMONINFERNALtype = message.data.IgnitionAbilityDEMONINFERNALtype;
					variables.heatabsorbed = message.data.heatabsorbed;
					variables.HasAwakened = message.data.HasAwakened;
					variables.Generation = message.data.Generation;
					variables.FireSpeed = message.data.FireSpeed;
					variables.FireResistancedefense = message.data.FireResistancedefense;
					variables.FireResistance = message.data.FireResistance;
					variables.FirePower = message.data.FirePower;
					variables.FireHealth = message.data.FireHealth;
					variables.adollalburstevel = message.data.adollalburstevel;
					variables.Adollaburst = message.data.Adollaburst;
					variables.secondgenobsorb = message.data.secondgenobsorb;
					variables.FireResistanceMax = message.data.FireResistanceMax;
					variables.joinworldfirsttimestamina = message.data.joinworldfirsttimestamina;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
