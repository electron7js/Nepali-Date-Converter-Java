import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class NepaliDate {

    private static final Map<Integer, int[]> nepaliMap = new HashMap<Integer, int[]>();

    static {
        nepaliMap.put(2000, new int[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2001, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2002, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2003, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2004, new int[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2005, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2006, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2007, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2008, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31 });
        nepaliMap.put(2009, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2010, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2011, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2012, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30 });
        nepaliMap.put(2013, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2014, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2015, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2016, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30 });
        nepaliMap.put(2017, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2018, new int[] { 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2019, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2020, new int[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2021, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2022, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30 });
        nepaliMap.put(2023, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2024, new int[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2025, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2026, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2027, new int[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2028, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2029, new int[] { 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2030, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2031, new int[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2032, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2033, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2034, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2035, new int[] { 30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31 });
        nepaliMap.put(2036, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2037, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2038, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2039, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30 });
        nepaliMap.put(2040, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2041, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2042, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2043, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30 });
        nepaliMap.put(2044, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2045, new int[] { 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2046, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2047, new int[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2048, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2049, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30 });
        nepaliMap.put(2050, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2051, new int[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2052, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2053, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30 });
        nepaliMap.put(2054, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2055, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2056, new int[] { 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2057, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2058, new int[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2059, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2060, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2061, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2062, new int[] { 30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31 });
        nepaliMap.put(2063, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2064, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2065, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2066, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31 });
        nepaliMap.put(2067, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2068, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2069, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2070, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30 });
        nepaliMap.put(2071, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2072, new int[] { 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2073, new int[] { 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 31 });
        nepaliMap.put(2074, new int[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2075, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2076, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30 });
        nepaliMap.put(2077, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2078, new int[] { 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2079, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2080, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30 });
        nepaliMap.put(2081, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2082, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2083, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2084, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2085, new int[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2086, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2087, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2088, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2089, new int[] { 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31 });
        nepaliMap.put(2090, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2091, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2092, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2093, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31 });
        nepaliMap.put(2094, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2095, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2096, new int[] { 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31 });
        nepaliMap.put(2097, new int[] { 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30 });
        nepaliMap.put(2098, new int[] { 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30 });
        nepaliMap.put(2099, new int[] { 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30 });
    }

    private static final LocalDate ENGLISH_START_DATE = LocalDate.of(1943, 4, 14);

    public static String getNepaliDate(LocalDate englishDate) throws Exception {
        if (englishDate.isBefore(ENGLISH_START_DATE) ){
            throw new Exception("Only dates after 1943-04-14 are supported");
        }
        long totalDays = ChronoUnit.DAYS.between(ENGLISH_START_DATE, englishDate);
        int bsYear = 2000;
        int bsMonth = 1; // Assuming months are 1-based
        int bsDay = 1;

        while (totalDays > 0) {
            int daysInMonth = nepaliMap.get(bsYear)[bsMonth - 1]; // Adjust for 0-based index

            if (totalDays >= daysInMonth) {
                totalDays -= daysInMonth;
                bsMonth++;

                if (bsMonth > 12) { // Adjusted condition
                    bsMonth = 1;
                    bsYear++;
                }
            } else {
                bsDay += totalDays;
                if (bsDay > daysInMonth) { // Prevent overflow
                    bsDay = daysInMonth;
                }
                totalDays = 0;
            }
        }

        return bsYear + "-" + String.format("%02d", bsMonth) + "-" + String.format("%02d", bsDay);
    }

    public static String getNepaliDate(java.sql.Date sqlDate) throws Exception {
        return getNepaliDate(sqlDate.toLocalDate());
    }

    public static String getNepaliDate(String dateStr) throws Exception {
        try {
            return getNepaliDate(LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE));
        } catch (DateTimeParseException e) {
            throw new Exception("Invalid date format: " + dateStr);
        }
    }

}
