package com.example.sharedkernal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {
    private Long totalPages;
    private Long totalRecords;
    private Long currentPage;
    private Long pageSize;
    private T data;
}
