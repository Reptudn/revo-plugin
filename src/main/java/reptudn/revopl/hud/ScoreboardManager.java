package reptudn.revopl.hud;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ScoreboardManager {

     private Scoreboard board;
     private Scoreboard tagB;
     private Objective o;
     private Objective tag;
     private HashMap<OfflinePlayer, Score> teams = new HashMap<OfflinePlayer, Score>();

     public ScoreboardManager(){

          board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
          o = board.registerNewObjective("Teams", "dummy");
          o.setDisplayName("Teams");
          o.setDisplaySlot(DisplaySlot.SIDEBAR);

     }


     public void addTeams(Player player1, Player player2){

          String teamname = player1.getDisplayName().substring(2) + player2.getDisplayName().substring(2);
          o = board.registerNewObjective(teamname, "dummy");
          o.setDisplayName(teamname);
          setTeamNameTag(teamname);

     }

     private void setTeamNameTag(String teamname){

          tagB = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
          tag = tagB.registerNewObjective("Tag", "dummy");
          o.setDisplayName(teamname);
     }

}
