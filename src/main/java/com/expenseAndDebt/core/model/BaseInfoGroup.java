package com.expenseAndDebt.core.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "BASE_INFO_GROUP")
@Setter
@Getter
public class BaseInfoGroup extends BaseEntity<BaseEntity, BaseInfoGroupDTO> {

    @NotNull
    @Column(name = "CODE", nullable = false, unique = true, updatable = false)
    private Long code;

    @NotNull
    @Column(name = "TITLE", nullable = false, unique = true, updatable = false)
    private String title;

    @Column(name = "ENGLISH_TITLE")
    private String englishTitle;

    @OneToMany(mappedBy = "baseInfoGroup")
    private List<BaseInfoValue> baseInfoValueList;

    @Override
    public void getDomainObject(BaseInfoGroupDTO dto) {
        this.id = dto.getId();
        this.version = dto.getVersion();
        this.code = dto.getCode();
        this.title = dto.getTitle();
        this.englishTitle = dto.getEnglishTitle();
    }

    @Override
    public BaseInfoGroupDTO getDtoObject() {
        BaseInfoGroupDTO dto = new BaseInfoGroupDTO();
        dto.setId(this.id);
        dto.setVersion(this.version);
        dto.setCreatedDate(this.getCreatedDate());
        dto.setIsDeleted(this.getIsDeleted());
        dto.setIsEnabled(this.getIsEnabled());
        dto.setDescription(this.getDescription());
        dto.setCode(this.getCode());
        dto.setTitle(this.getTitle());
        dto.setEnglishTitle(this.getEnglishTitle());
        return dto;
    }
}
