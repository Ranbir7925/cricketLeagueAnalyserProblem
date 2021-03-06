import com.google.gson.Gson;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    Map<String, LeagueDAO> leagueMap = new HashMap<>();

    public int loadLeagueData(IplEnumCollection.CricketerSkill cricketerSkill, String... csvFilePath) throws CricketLeagueAnalyserException {
        leagueMap = new CricketLeagueLoader().loadLeagueData(cricketerSkill, csvFilePath);
        return leagueMap.size();
    }

    public String getBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> battingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(battingAverageComparator.reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getStrikeRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> battingStrikeRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingStrikeRate);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(battingStrikeRateComparator.reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getMaximumSixesAndFoursWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> maxSixOrFourComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(maxSixOrFourComparator.reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getMaximumSixesAndFoursWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> sixesAndFoursComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.sixes * 6 + iplFactSheet.fours * 4);
        Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingStrikeRate);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(sixesAndFoursComparator.thenComparing(strikingRateComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getGreatAverageWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
        Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingStrikeRate);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(strikingRateComparator.thenComparing(averageComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getMaximumRunsWithBestAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
        Comparator<LeagueDAO> runsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.runs);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(runsComparator.thenComparing(averageComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getBowlingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> bowlingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(bowlingAverageComparator.reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getBowlerEconomyRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> economyComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.economyRate);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(economyComparator.reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getBowlerStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> bowlerStrikeRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingStrikeRate);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(bowlerStrikeRateComparator.reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getFourWicketsAndFiveWicketsWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> fourAndFiveWicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.fourWicket + iplFactSheet.fiveWicket);
        Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingStrikeRate);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(fourAndFiveWicketsComparator.thenComparing(strikingRateComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getBowlersHavingGreatAverageWithBestStrikingRateWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
        Comparator<LeagueDAO> strikingRateComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingStrikeRate);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(averageComparator.thenComparing(strikingRateComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getBestBowlerAndBestBatterWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> battingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
        Comparator<LeagueDAO> bowlingAverageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(battingAverageComparator.thenComparing(bowlingAverageComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getBowlersTakingMaximumWicketsWithBestBowlingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> wicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.wicket);
        Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.bowlingAverage);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(wicketsComparator.thenComparing(averageComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getAllRounderWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> wicketsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.wicket);
        Comparator<LeagueDAO> runsComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.runs);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(runsComparator.thenComparing(wicketsComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getMaximumHundredAndBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> centuryComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.hundred);
        Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(centuryComparator.thenComparing(averageComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }

    public String getMinimumHundredAndMinimumFiftyWithBestBattingAverageWiseSortedIPLData() throws CricketLeagueAnalyserException {
        Comparator<LeagueDAO> minimumHalfCenturyAndCenturyComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.hundred * 100 + iplFactSheet.fifty * 50 == 0);
        Comparator<LeagueDAO> averageComparator = Comparator.comparing(iplFactSheet -> iplFactSheet.battingAverage);
        List<LeagueDAO> leagueDAOList = leagueMap.values().stream().sorted(minimumHalfCenturyAndCenturyComparator.thenComparing(averageComparator).reversed()).collect(Collectors.toList());
        return new Gson().toJson(leagueDAOList);
    }
}