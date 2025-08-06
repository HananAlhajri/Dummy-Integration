package com.coop.vrc.model.constant;

import java.util.*;

public interface Constant {

    String PLACE_HOLDER = "{}";

    interface Regex {
        String PLATE_NUMBER_REGEX = "\\d{1,4}";
    }

    interface LookupValues {
        LinkedHashMap<Integer, String> REGISTRATION_TYPES_MAP = new LinkedHashMap<>() {{
            put(1, "خاص");
            put(2, "نقل خاص");
            put(3, "نقل عام");
            put(4, "دبلوماسي");
            put(5, "دراجات نارية");
        }};

        LinkedHashMap<String, String> PLATE_LETTERS_MAP = new LinkedHashMap<>() {{
            put("أ", "A");
            put("ب", "B");
            put("ح", "J");
            put("د", "D");
            put("ر", "R");
            put("س", "S");
            put("ص", "X");
            put("ط", "T");
            put("ع", "E");
            put("ق", "G");
            put("ك", "K");
            put("ل", "L");
            put("م", "Z");
            put("ن", "N");
            put("ه", "H");
            put("و", "U");
            put("ى", "V");
        }};
    }

    interface DummyData {

        LinkedHashMap<Integer, String> VEHICLE_MAKERS = new LinkedHashMap<>() {{
            put(1, "نيسان");
            put(2, "ايسوزو");
            put(3, "هيونداي");
            put(4, "شيفروليه");
            put(5, "جاك");
            put(6, "بورش");
            put(8, "جي ام سي");
            put(9, "تويوتا");
            put(12, "ميتسوبيشي");
            put(14, "فورد");
            put(15, "مرسيدس");
            put(16, "لكزس");
            put(17, "فولفو");
            put(13, "جيلي");
            put(19, "شانجان");
            put(7, "بي ام دبليو");
        }};

        Map<String, List<String>> VEHICLE_MAKER_MODELS = new LinkedHashMap<>() {{
            put("نيسان", Arrays.asList("تيما", "باترول", "صني"));
            put("ايسوزو", Arrays.asList("ديماكس", "ديماكس D-MAX"));
            put("هيونداي", Arrays.asList("النترا", "سوناتا", "توسان"));
            put("شيفروليه", Arrays.asList("كابرس", "تاهو", "كروز"));
            put("جاك", Arrays.asList("S2", "T6"));
            put("بورش", Arrays.asList("كايين", "911", "باناميرا"));
            put("جي ام سي", Arrays.asList("سيرادوا", "يوكن"));
            put("تويوتا", Arrays.asList("كامري", "كورولا", "هايلكس", "لاندكروزر"));
            put("ميتسوبيشي", Arrays.asList("لانسر", "أوتلاندر", "باجيرو"));
            put("فورد", Arrays.asList("F-150", "موستانج", "إكسبلورر"));
            put("مرسيدس", Arrays.asList("C-Class", "E-Class", "GLA"));
            put("لكزس", Arrays.asList("RX", "ES", "LX"));
            put("فولفو", Arrays.asList("XC90", "S60", "V60"));
            put("جيلي", Arrays.asList("إمجراند", "إمجراند X7", "كولراي"));
            put("شانجان", Arrays.asList("CS35", "CS75", "Eado"));
            put("بي ام دبليو", Arrays.asList("سلسلة 3", "سلسلة 5", "X5"));
        }};

        Map<Integer, String> VEHICLE_COLORS = new LinkedHashMap<>() {{
            put(1, "أبيض");
            put(2, "أسود");
            put(3, "أحمر");
            put(4, "أخضر");
            put(5, "أزرق");
            put(6, "بيج");
            put(7, "أصفر");
            put(8, "فضي");
            put(9, "بني");
            put(10, "رمادي");
            put(11, "ذهبي");
        }};

        int[] MANUFACTURING_YEARS = {
                2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009,
                2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019,
                2020, 2021, 2022, 2023, 2024, 2025, 2026
        };

        Map<String, int[]> MAKER_MANUFACTURING_YEARS_RANGE = new HashMap<>() {{
            put("تويوتا", new int[]{2005, 2025});
            put("نيسان", new int[]{2000, 2023});
            put("جيلي", new int[]{2010, 2025});
            put("هيونداي", new int[]{2007, 2024});
            put("مرسيدس", new int[]{2000, 2025});
            put("بورش", new int[]{2010, 2025});
            put("ايسوزو", new int[]{2005, 2023});
            put("شيفروليه", new int[]{2000, 2024});
            put("جاك", new int[]{2012, 2025});
            put("جي ام سي", new int[]{2000, 2023});
            put("ميتسوبيشي", new int[]{2005, 2024});
            put("فورد", new int[]{2000, 2025});
            put("لكزس", new int[]{2005, 2025});
            put("فولفو", new int[]{2000, 2024});
            put("شانجان", new int[]{2010, 2025});
            put("بي ام دبليو", new int[]{2000, 2025});
        }};

    }

}
