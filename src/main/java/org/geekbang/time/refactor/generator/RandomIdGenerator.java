package org.geekbang.time.refactor.generator;

import com.google.common.annotations.VisibleForTesting;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class RandomIdGenerator implements IdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String generate() throws IdGenerationFailureException {
        String hostName = null;
        try {
            hostName = getLastfieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("host name is empty.");
        }
        String randomString = generateRandomAlphameric(8);
        long currentTimeMillis = System.currentTimeMillis();
        String id = String.format("%s-%d-%s", hostName, currentTimeMillis, randomString);
        return id;
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("length can not be less than zero.");
        }
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        int maxAscii = 'z';
        while (count < length) {
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char)randomAscii;
                count++;
            }
        }
        return new String(randomChars);
    }

    private String getLastfieldOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("...");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
        return substrOfHostName;
    }

    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("hostName can not be null.");
        }
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

}
