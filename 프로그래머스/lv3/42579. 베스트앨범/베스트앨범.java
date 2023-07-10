import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genresScores = new HashMap<>(); //장르별 스트리밍 맵
        Map<String, List<Song>> songsMap = new HashMap<>(); //각 장르별 노래 리스트 맵

        for(int i = 0; i < genres.length; i++)
        {
            genresScores.put(genres[i], genresScores.getOrDefault(genres[i], 0) + plays[i]);

            Song song = new Song();
            song.number = i;
            song.stmCtn = plays[i];
            List<Song> songsList = songsMap.getOrDefault(genres[i], new ArrayList<>());
            songsList.add(song);
            songsMap.put(genres[i], songsList);
        }

        List<String> descOrderGenresList = new ArrayList(); //장르별 스트리밍 내림차순 리스트
        while(genresScores.size() > 0)
        {
            Set<String> keys = genresScores.keySet();
            int maxScore = 0;
            String maxKey = "";
            for(String key : keys)
            {
                int score = genresScores.get(key);
                if(maxScore < score)
                {
                    maxScore = score;
                    maxKey = key;
                }
            }
            descOrderGenresList.add(maxKey);
            genresScores.remove(maxKey);
        }
        
        for(int i = 0; i < descOrderGenresList.size(); i++)
        {
            String genresName = descOrderGenresList.get(i);
            List<Song> songsList = songsMap.get(genresName);
            Collections.sort(songsList, (s1, s2) -> {
                if(s1.stmCtn > s2.stmCtn)
                    return -1;
                else if(s1.stmCtn == s2.stmCtn)
                    return 0;
                else
                    return 1;
            });
        }

        List<Integer> resultList = new ArrayList();
        for(String key : descOrderGenresList)
        {
            List<Song> list = songsMap.get(key);
            if(list.size() > 1) {
                resultList.add(list.get(0).number);
                resultList.add(list.get(1).number);
            }
            else
            {
                resultList.add(list.get(0).number);
            }
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = resultList.get(i);
        }

        return result;
    }

    class Song{
        public int number = -1;
        public int stmCtn = 0;
    }
}
