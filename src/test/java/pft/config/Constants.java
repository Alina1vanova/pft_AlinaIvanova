package pft.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public interface Constants {
    String HOME_PAGE_URL = "http://localhost/addressbookv4.1.4/";
    String LOGIN_PAGE_URL = "https://intranet-dev.zeo.lcl/login";
    String LOGOUT_URL = "https://intranet-dev.zeo.lcl/logout";
    String LOGIN = "Linka";
    String DISABLED_LOGIN = "Rom";
    String PASSWORD = "12345";
    String COUNTRY_CODE = "+38 0";

    List<String> PHONE_CODES_KIEVSTAR = new ArrayList<String>(Arrays.asList("98", "97", "96", "67"));
    List<String> PHONE_CODES_MTS = new ArrayList<String>(Arrays.asList("50", "66", "95", "99"));
    List<String> PHONE_CODES_LIFE = new ArrayList<String>(Arrays.asList("63", "93"));
    String KIEVSTAR_OPERATOR_NAME = "kievstar";
    String MTS_OPERATOR_NAME = "mts";
    String LIFE_OPERATOR_NAME = "life";

    HashMap<String, List<String>> PHONE_CODES = new HashMap<String, List<String>>() {{
        put(KIEVSTAR_OPERATOR_NAME, PHONE_CODES_KIEVSTAR);
        put(MTS_OPERATOR_NAME, PHONE_CODES_MTS);
        put(LIFE_OPERATOR_NAME, PHONE_CODES_LIFE);
    }};

    List<String> SKILLS = new ArrayList<String>(Arrays.asList("Marketing Communications", "Python", "Testing"));
    String DASHBOARD_TAB_TITLE = "ZEO Alliance :: Dashboard";
    String PROFILE_TAB_TITLE = "ZEO Alliance :: Profile";
    String TIMETABLE_TAB_TITLE = "ZEO Alliance :: Timetable";
}
