package uk.hmrc;

/**
 * 
 * @author NARAYANA RAO
 *
 */
public enum ItemEnum {
    Apple ("Apple"),
    Orange ("Orange");

    private final String value;

    /**
     * @param value
     */
    private ItemEnum(final String value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return value;
    }

}
