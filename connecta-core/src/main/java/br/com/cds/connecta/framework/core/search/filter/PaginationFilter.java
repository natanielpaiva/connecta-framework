package br.com.cds.connecta.framework.core.search.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Componente de paginação
 * 
 * @author vinicius.pires
 */
public class PaginationFilter {

    private HashMap<String, Sort.Direction> sort;
    private Integer page;
    private Integer count;
    private Boolean array;
    private HashMap<String, Object> filter;

    /**
     * Cria um objeto {@link Sort} de acordo com os parâmetros passados para o PaginationFilter
     * @return return
     * @throws IllegalStateException Caso não tenha informações suficientes para criar o Sort
     */
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

    /**
     * Cria um objeto {@link Pageable} de acordo com os parâmetros de paginação
     * passados para o PaginationFilter
     * 
     * @return return
     * @throws IllegalStateException Caso não tenha informações suficientes para criar o Pageable
     */
    public Pageable makePageable() {
        if ( !hasPagination() ) {
            throw new IllegalStateException("Invalid pagination");
        }
        
        PageRequest pageRequest = new PageRequest(page - 1, count);
        
        return pageRequest;
    }
    
    /**
     * Cria um objeto {@link Pageable} de acordo com os parâmetros de paginação
     * e ordenação passados para o PaginationFilter
     * @return return
     * @throws IllegalStateException Caso não tenha informações suficientes
     * para criar o Pageable com ordenação
     */
    public Pageable makeSortablePageable() {
        if ( !hasPagination() ) {
            throw new IllegalStateException("Invalid sortable pagination");
        }
        
        PageRequest pageRequest = new PageRequest(page - 1, count, makeSort());
        
        return pageRequest;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    /**
     * @return se o conteúdo da resposta deve ser um Array ou o objeto {@link Pageable}
     */
    public boolean isArray() {
        return array != null && array;
    }

    public void setArray(Boolean array) {
        this.array = array;
    }

    public boolean hasPagination() {
        return page != null && count != null;
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
    
    public boolean hasFilter(){
        return filter != null && filter.size() > 0;
    }
    
    public HashMap<String, Object> getFilter() {
        return filter;
    }

    public void setFilter(HashMap<String, Object> filter) {
        this.filter = filter;
    }
}
