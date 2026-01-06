package jpabook.practice.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

import java.util.Objects;

@Embeddable
public class Code {
    private String code;
    private String companyCode;

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Code code1 = (Code) object;
        return Objects.equals(code, code1.code) && Objects.equals(companyCode, code1.companyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, companyCode);
    }
}
