package entity;

public enum Climate {
    RAIN_FOREST,
    HUMIDCONTINENTAL,
    OCEANIC,
    MEDITERRANIAN,
    STEPPE;

    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var forms : values()) {
            nameList.append(forms.name()).append("\n");
        }
        return nameList.substring(0, nameList.length()-1);
    }
}
