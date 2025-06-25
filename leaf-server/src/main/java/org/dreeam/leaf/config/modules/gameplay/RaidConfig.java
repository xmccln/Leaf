package org.dreeam.leaf.config.modules.gameplay;

import org.dreeam.leaf.config.ConfigModules;
import org.dreeam.leaf.config.EnumConfigCategory;

public class RaidConfig extends ConfigModules {

    public String getBasePath() {
        return EnumConfigCategory.GAMEPLAY.getBaseKeyName() + ".raid";
    }

    public static boolean allowBadOmenTriggerRaid = false;
    public static boolean giveBadOmenWhenKillPatrolLeader = false;
    public static boolean useOldFindSpawnPosition = false;
    public static boolean skipHeightCheck = false;
    public static boolean skipSelfRaidCheck = false;

    @Override
    public void onLoaded() {
        config.addCommentRegionBased(getBasePath(), """
                Settings for raid mechanics.
                These settings control raid behavior.""", """
                这些设置用于控制袭击机制.
                用于修改袭击相关的行为.""");

        allowBadOmenTriggerRaid = config.getBoolean(getBasePath() + ".allow-bad-omen-trigger-raid", 
            allowBadOmenTriggerRaid, """
            Whether bad omen effect can trigger raids directly.
            When enabled, raids will be triggered immediately upon entering a village with bad omen.""");

        giveBadOmenWhenKillPatrolLeader = config.getBoolean(getBasePath() + ".give-bad-omen-when-kill-patrol-leader", 
            giveBadOmenWhenKillPatrolLeader, """
            Whether killing a patrol captain gives bad omen effect.
            Controls if players receive the bad omen effect after killing patrol leaders.""");

        useOldFindSpawnPosition = config.getBoolean(getBasePath() + ".use-old-find-spawn-position", 
            useOldFindSpawnPosition, """
            Whether to use the old raid spawn position finding algorithm.
            The old algorithm may be more lenient with spawn positions.""");

        skipHeightCheck = config.getBoolean(getBasePath() + ".skip-height-check", 
            skipHeightCheck, """
            Whether to skip height check when finding raid spawn positions.
            Skipping height checks may allow raiders to spawn in more locations.""");
        skipSelfRaidCheck = config.getBoolean(getBasePath() + ".skip-self-raid-check", 
            skipSelfRaidCheck, """
            Whether to skip self-raid check when finding raid spawn positions.
            Skipping self-raid checks may allow raiders to spawn in more locations.""");
    }
}