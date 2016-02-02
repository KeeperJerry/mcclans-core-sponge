package nl.riebie.mcclans.clan;

import nl.riebie.mcclans.ClansImpl;
import nl.riebie.mcclans.api.enums.Permission;

/**
 * Created by K.Volkers on 19-1-2016.
 */
public class RankFactory {

    private static RankFactory instance;
    private final static String OWNER_IDENTIFIER = "Owner";
    private final static String MEMBER_IDENTIFIER = "Member";
    private final static String RECRUIT_IDENTIFIER = "Recruit";

    private static RankImpl owner;
    private static RankImpl recruit;

    private final static int OWNER_ID = -2;
    private final static int RECRUIT_ID = -3;

    public static RankFactory getInstance() {
        if (instance == null) {
            instance = new RankFactory();
        }
        return instance;
    }

    public RankImpl createOwner() {
        if (owner == null) {
            owner = new RankImpl.Builder(OWNER_ID, OWNER_IDENTIFIER).unchangeable().build();
            owner.addPermission(Permission.home.name());
            owner.addPermission(Permission.sethome.name());
            owner.addPermission(Permission.invite.name());
            owner.addPermission(Permission.remove.name());
            owner.addPermission(Permission.disband.name());
            owner.addPermission(Permission.friendlyfire.name());
            owner.addPermission(Permission.coords.name());
            owner.addPermission(Permission.tag.name());
            owner.addPermission(Permission.rank.name());
            owner.addPermission(Permission.setrank.name());
            owner.addPermission(Permission.ally.name());
            owner.addPermission(Permission.clanchat.name());
            owner.addPermission(Permission.allychat.name());
        }
        return owner;
    }

    public RankImpl createMember() {
        RankImpl rank = new RankImpl.Builder(ClansImpl.getInstance().getNextAvailableRankID(), MEMBER_IDENTIFIER).build();
        rank.addPermission(Permission.home.name());
        rank.addPermission(Permission.coords.name());
        rank.addPermission(Permission.clanchat.name());
        rank.addPermission(Permission.allychat.name());
        return rank;
    }

    public RankImpl createRecruit() {
        if (recruit == null) {
            recruit = new RankImpl.Builder(RECRUIT_ID, RECRUIT_IDENTIFIER).unchangeable().build();
            recruit.addPermission(Permission.clanchat.name());
        }

        return recruit;
    }

    public RankImpl createNewRank(String rankName) {
        RankImpl newRank = new RankImpl.Builder(ClansImpl.getInstance().getNextAvailableRankID(), rankName).build();
        return newRank;
    }

    public static String getOwnerIdentifier() {
        return OWNER_IDENTIFIER;
    }

    public static String getMemberIdentifier() {
        return MEMBER_IDENTIFIER;
    }

    public static String getRecruitIdentifier() {
        return RECRUIT_IDENTIFIER;
    }

    public static int getOwnerID() {
        return OWNER_ID;
    }

    public static int getRecruitID() {
        return RECRUIT_ID;
    }
}