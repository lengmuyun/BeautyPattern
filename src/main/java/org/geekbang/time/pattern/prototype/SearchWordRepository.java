package org.geekbang.time.pattern.prototype;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SearchWordRepository {

    private List<SearchWord> initializeData = Collections.emptyList();
    private Random random = new Random();

    /**
     * 从数据库中取出更新时间>lastUpdateTime的数据
     * @param lastUpdateTime
     * @return
     */
    public List<SearchWord> getSearchWords(long lastUpdateTime) {
        if (lastUpdateTime == -1) {
            return getInitializeData();
        } else {
            List<SearchWord> allData = getAllSearchWords();
            return allData.stream()
                    .filter(searchWord -> searchWord.getLastUpdateTime() > lastUpdateTime)
                    .collect(Collectors.toList());
        }
    }

    public List<SearchWord> getAllSearchWords() {
        List<SearchWord> result = initializeData;
        result.forEach(searchWord -> {
            if (random.nextBoolean()) {
                long count = randomCount();
                long timeLate = randomTime();
                searchWord.increaseCount(count);
                searchWord.timeLate(timeLate);
            }
        });
        return result;
    }

    /**
     * 更新时间随机[1, 61]
     * @return
     */
    private long randomTime() {
        return random.nextInt(60) + 1;
    }

    /**
     * 点击数随机[1, 11]
     * @return
     */
    private int randomCount() {
        return random.nextInt(10) + 1;
    }

    private List<SearchWord> getInitializeData() {
        if (initializeData.isEmpty()) {
            initializeData = Arrays.asList(new SearchWord("算法", 2098L, 1548506764L),
                    new SearchWord("设计模式", 1938L, 1548470987L),
                    new SearchWord("王争", 13098L, 1548384124L));
        }
        return initializeData;
    }

}
