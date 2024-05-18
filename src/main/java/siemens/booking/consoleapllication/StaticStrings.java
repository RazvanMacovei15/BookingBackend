package siemens.booking.consoleapllication;

public class StaticStrings {
    public static final String MAIN_MENU = """
                                         
            1. Search hotel by radius
            2. Check your reservations
            0. Exit the application
                                         
            Choice:
            """;

    public static final String RADIUS_MENU = """

            Radius(km):""";

    public static final String AFTER_RADIUS_INPUT= """
            
            Getting user information...
            Getting location...""";

    public static final String HOTEL_SEARCH_RESULT = """
            Hotels found:""";

    public static final String HOTEL_SEARCH_RESULT_EMPTY = """
            No hotels found""";

    public static final String HOTEL_SELECTION= """
            Select a hotel by entering the hotel id:""";

    public static final String ROOM_SELECTION= """
            Select a room by entering the room id:""";

    public static final String ROOM_SELECT_PROMPT = """
            Enter carefully with this LocalDate format: yyyy-MM-dd the starting date of the reservation:""";

    public static final String ROOM_SELECT_PROMPT_END = """
            Enter carefully with this LocalDate format: yyyy-MM-dd the ending date of the reservation:""";


}
