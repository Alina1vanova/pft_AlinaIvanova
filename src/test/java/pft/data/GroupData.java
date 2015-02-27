package pft.data;

import java.util.Collections;

/**
 * Created by linka on 19.02.2015.
 */
public class GroupData implements Comparable<GroupData> {

    private String name;
    private String header;
    private String footer;

    public GroupData() {
    }

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }


    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "GroupData[" +
                "name='" + name +
                ", header='" + header +
                ", footer='" + footer +
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

            return this.name.toLowerCase().compareTo(other.name.toLowerCase());

    }

    @Override
    public int hashCode() {
        return 0;
    }
}