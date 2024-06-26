package com.fuyuvulpes.yoamod.game.client.gui;


import com.fuyuvulpes.yoamod.YOAMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CrucibleScreen extends AbstractContainerScreen<CrucibleMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(YOAMod.MODID, "textures/gui/container/crucible.png");
    private static final ResourceLocation ARROW = new ResourceLocation(YOAMod.MODID, "container/crucible/arrow");
    private static final ResourceLocation FUEL = new ResourceLocation(YOAMod.MODID, "container/crucible/fuel");

    public CrucibleScreen(CrucibleMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
        renderFuel(guiGraphics,x,y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blitSprite(ARROW,64, 9, 0,0, x + 61, y + 22, menu.getScaledProgress(), 9);
        }
    }

    private void renderFuel(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isLit()) {
            guiGraphics.blitSprite(FUEL,14,11,0,11 - menu.getScaledUsage(),x + 81, y + 49 - menu.getScaledUsage(), 14, menu.getScaledUsage());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics,mouseX,mouseY,delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}