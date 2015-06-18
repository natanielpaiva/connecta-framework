/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.core.filter;

import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author pires
 */
public class PaginationFilterTest {
    
    PaginationFilter newFilter(Integer page, Integer size, String... args) {
        
        HashMap<String, Sort.Direction> sort = null;
        if ( args != null && args.length > 0 ) {
            sort = new HashMap<>();
            for (int i = 0; i < args.length; i += 2) {
                sort.put(args[i], Sort.Direction.fromString(args[i + 1]));
            }
        }
        
        PaginationFilter filter = new PaginationFilter();
        
        if (page != null) {
            filter.setPage(page+1);
        }
        if (size != null) {
            filter.setSize(size);
        }
        if (sort != null) {
            filter.setSort(sort);
        }
        
        return filter;
    }
    
    @Test
    public void makePageableWithoutSort() {
        PaginationFilter filter = newFilter(0, 10);
        Pageable pageable = filter.makePageable();
        
        assertThat(pageable.getPageNumber(), equalTo(0));
        assertThat(pageable.getPageSize(), equalTo(10));
        assertThat(pageable.getSort(), equalTo(null));
    }
    
    @Test
    public void makePageableWithSort() {
        PaginationFilter filter = newFilter(0, 10, "name", "ASC");
        Pageable pageable = filter.makeSortablePageable();
        
        assertThat(pageable.getPageNumber(), equalTo(0));
        assertThat(pageable.getPageSize(), equalTo(10));
        assertThat(pageable.getSort(), notNullValue());
        assertThat(pageable.getSort().getOrderFor("name").getDirection(), equalTo(Sort.Direction.ASC));
        
        filter = newFilter(0, 10, "name", "asc", "description", "DESC");
        pageable = filter.makeSortablePageable();
        
        assertThat(pageable.getPageNumber(), equalTo(0));
        assertThat(pageable.getPageSize(), equalTo(10));
        assertThat(pageable.getSort(), notNullValue());
        assertThat(pageable.getSort().getOrderFor("name").getDirection(), equalTo(Sort.Direction.ASC));
        assertThat(pageable.getSort().getOrderFor("description").getDirection(), equalTo(Sort.Direction.DESC));
    }
    
    @Test
    public void makeSort() {
        PaginationFilter filter = newFilter(null, null, "name", "ASC");
        
        Sort sort = filter.makeSort();
        
        assertThat(sort, notNullValue());
        assertThat(sort.getOrderFor("name").getDirection(), equalTo(Sort.Direction.ASC));
        
        filter = newFilter(null, null, "name", "asc", "description", "DESC");
        
        sort = filter.makeSort();
        
        assertThat(sort, notNullValue());
        assertThat(sort.getOrderFor("name").getDirection(), equalTo(Sort.Direction.ASC));
        assertThat(sort.getOrderFor("description").getDirection(), equalTo(Sort.Direction.DESC));
    }
    
    @Test
    public void informsWhetherHasPagination() {
        PaginationFilter filter = newFilter(null, null);
        assertThat(filter.hasPagination(), equalTo(false));
        
        filter = newFilter(null, 10);
        assertThat(filter.hasPagination(), equalTo(false));
        
        filter = newFilter(0, null);
        assertThat(filter.hasPagination(), equalTo(false));
        
        filter = newFilter(0, 10);
        assertThat(filter.hasPagination(), equalTo(true));
    }
    
    @Test
    public void informsWhetherHasSorting() {
        PaginationFilter filter = newFilter(null, null);
        assertThat(filter.hasSorting(), equalTo(false));
        
        filter = newFilter(null, null);
        filter.setSort(new HashMap<String, Sort.Direction>());
        assertThat(filter.hasSorting(), equalTo(false));
        
        filter = newFilter(null, null, "name", "ASC");
        assertThat(filter.hasSorting(), equalTo(true));
        
        filter = newFilter(null, null, "name", "asc", "description", "DESC");
        assertThat(filter.hasSorting(), equalTo(true));
    }
    
    @Test
    public void informsWhetherHasOnlySorting() {
        PaginationFilter filter = newFilter(null, null);
        assertThat(filter.hasOnlySorting(), equalTo(false));
        
        filter = newFilter(0, 10);
        assertThat(filter.hasOnlySorting(), equalTo(false));
        
        filter = newFilter(0, 10, "name", "asc");
        assertThat(filter.hasOnlySorting(), equalTo(false));
        
        filter = newFilter(null, null, "name", "asc");
        assertThat(filter.hasOnlySorting(), equalTo(true));
    }
    
    @Test
    public void informsWhetherHasOnlyPaging() {
        PaginationFilter filter = newFilter(null, null);
        assertThat(filter.hasOnlyPagination(), equalTo(false));
        
        filter = newFilter(null, null, "name", "asc");
        assertThat(filter.hasOnlyPagination(), equalTo(false));
        
        filter = newFilter(0, 10, "name", "asc");
        assertThat(filter.hasOnlyPagination(), equalTo(false));
        
        filter = newFilter(0, 10);
        assertThat(filter.hasOnlyPagination(), equalTo(true));
    }
    
    @Test
    public void informsWhetherHasPagingAndSorting() {
        PaginationFilter filter = newFilter(null, null);
        assertThat(filter.hasPaginationAndSorting(), equalTo(false));
        
        filter = newFilter(null, null, "name", "asc");
        assertThat(filter.hasPaginationAndSorting(), equalTo(false));
        
        filter = newFilter(0, 10);
        assertThat(filter.hasPaginationAndSorting(), equalTo(false));
        
        filter = newFilter(0, 10, "name", "asc");
        assertThat(filter.hasPaginationAndSorting(), equalTo(true));
    }
    
    @Test
    public void informsIfReturnTypeIsArray() {
        PaginationFilter filter = newFilter(null, null);
        
        filter.setArray(true);
        assertThat(filter.isArray(), equalTo(true));
        
        filter.setArray(false);
        assertThat(filter.isArray(), equalTo(false));
        
        filter.setArray(null);
        assertThat(filter.isArray(), equalTo(false));
    }
    
    @Test(expected = IllegalStateException.class)
    public void failsOnInvalidPaginationPage() {
        PaginationFilter filter = newFilter(null, 10);
        filter.makePageable();
    }
    
    @Test(expected = IllegalStateException.class)
    public void failsOnInvalidPaginationSizeNull() {
        PaginationFilter filter = newFilter(0, null);
        filter.makePageable();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void failsOnInvalidPaginationSize() {
        PaginationFilter filter = newFilter(0, 0);
        filter.makePageable();
    }
    
    @Test(expected = IllegalStateException.class)
    public void failsOnInvalidPagination() {
        PaginationFilter filter = newFilter(null, null);
        filter.makePageable();
    }
    
    @Test(expected = IllegalStateException.class)
    public void failsOnInvalidSorting() {
        PaginationFilter filter = newFilter(null, null);
        filter.makeSort();
    }
    
    @Test(expected = IllegalStateException.class)
    public void failsOnInvalidPaginationAndSorting() {
        PaginationFilter filter = newFilter(null, null);
        filter.makeSortablePageable();
    }
}
