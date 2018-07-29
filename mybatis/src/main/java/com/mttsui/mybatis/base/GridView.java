package com.mttsui.mybatis.base;

import java.util.List;

public class GridView<T> {

    private List<T> rows;
    private int total;

    public GridView() {
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public GridView(List<T> rows, int total) {
        this.rows = rows;
        this.total = total;
    }
}
