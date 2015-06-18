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
 * Componente de paginação
 * 
 * @author vinicius.pires
 */
public class PaginationFilter {

    private HashMap<String, Sort.Direction> sort;
    private Integer page;
    private Integer size;
    private Boolean array;

    /**
     * Cria um objeto {@link Sort} de acordo com os parâmetros passados para o PaginationFilter
     * @return 
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
     * @return 
     * @throws IllegalStateException Caso não tenha informações suficientes para criar o Pageable
     */
    public Pageable makePageable() {
        if ( !hasPagination() ) {
            throw new IllegalStateException("Invalid pagination");
        }
        
        PageRequest pageRequest = new PageRequest(page - 1, size);
        
        return pageRequest;
    }
    
    /**
     * Cria um objeto {@link Pageable} de acordo com os parâmetros de paginação
     * e ordenação passados para o PaginationFilter
     * @return 
     * @throws IllegalStateException Caso não tenha informações suficientes
     * para criar o Pageable com ordenação
     */
    public Pageable makeSortablePageable() {
        if ( !hasPagination() ) {
            throw new IllegalStateException("Invalid sortable pagination");
        }
        
        PageRequest pageRequest = new PageRequest(page - 1, size, makeSort());
        
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
    /**
     * Retorna se o conteúdo da resposta deve ser um Array ou o objeto {@link Pageable}
     * @return 
     */
    public boolean isArray() {
        return array != null && array;
    }

    public void setArray(Boolean array) {
        this.array = array;
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
