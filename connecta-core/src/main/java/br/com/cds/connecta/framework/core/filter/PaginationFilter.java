/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.core.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 
 * @author pires
 */
public class PaginationFilter {

    private HashMap<String, Sort.Direction> sort;
    private Integer page;
    private Integer size;

    public Sort makeSort() {
        if ( sort == null ) {
            throw new IllegalStateException("Invalid sorting");
        }
        
        List<Sort.Order> orders = new ArrayList<>();

        for (Map.Entry<String, Sort.Direction> entry : sort.entrySet()) {
            orders.add(new Sort.Order(entry.getValue(), entry.getKey()));
        }
        
        return new Sort(orders);
    }

    public Pageable makePageable() {
        if ( !hasPagination() ) {
            throw new IllegalStateException("Invalid pagination");
        }
        
        return new PageRequest(page, size);
    }
    
    public Pageable makeSortablePageable() {
        if ( !hasPagination() ) {
            throw new IllegalStateException("Invalid sortable pagination");
        }
        
        return new PageRequest(page, size, makeSort());
    }

    public HashMap<String, Sort.Direction> getSort() {
        return sort;
    }

    public void setSort(HashMap<String, Sort.Direction> sort) {
        this.sort = sort;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean hasPagination() {
        return page != null && size != null;
    }

    public boolean hasSorting() {
        return sort != null && sort.size() > 0;
    }

    public boolean hasOnlySorting() {
        return hasSorting() && !hasPagination();
    }

    public boolean hasOnlyPagination() {
        return hasPagination() && !hasSorting();
    }

    public boolean hasPaginationAndSorting() {
        return hasPagination() && hasSorting();
    }
}
