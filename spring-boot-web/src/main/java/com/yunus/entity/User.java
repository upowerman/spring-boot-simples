package com.yunus.entity;

import com.google.common.base.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 6479278300635070094L;
    private Integer id;
    private String name;
    private Integer phone;
    private String address;
    private List<School> schools;

    @Data
    @NoArgsConstructor
    class School {
        private Integer id;
        private String name;
    }

    //@Override
    //public boolean equals(Object o) {
    //    if (this == o) {
    //        return true;
    //    }
    //    if (o == null || getClass() != o.getClass()) {
    //        return false;
    //    }
    //    User user = (User) o;
    //    return Objects.equals(id, user.getId());
    //}
    //
    //@Override
    //public int hashCode() {
    //    return Objects.hashCode(id);
    //}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
