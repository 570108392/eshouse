package it.qsbl.com.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Menu {
    private Integer mid;
    private Integer pid;

    private String mname;

    private String mdesc;

    private Integer rid;

    private String menuUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(mid, menu.mid) &&
                Objects.equals(pid, menu.pid) &&
                Objects.equals(mname, menu.mname) &&
                Objects.equals(mdesc, menu.mdesc) &&
                Objects.equals(rid, menu.rid) &&
                Objects.equals(menuUrl, menu.menuUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mid, pid, mname, mdesc, rid, menuUrl);
    }
}