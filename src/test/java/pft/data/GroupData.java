package pft.data;

/**
 * Created by linka on 19.02.2015.
 */
public class GroupData implements Comparable<GroupData> {

    private String name;
    private String header;

    private String footer;

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData[" +
                "name=" + name +
                ", header=" + header +
                ", footer=" + footer +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        if (!name.equals(groupData.name)) return false;
        return true;
    }

    @Override
    public int compareTo(GroupData other) {
        if (this.name != null & other.name != null) {
            return this.name.toLowerCase().compareTo(other.name.toLowerCase());
        } else
            return -1;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }
}