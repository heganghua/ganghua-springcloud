package xyz.ganghua.gateway.admin.entity.form;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class TestValidatorForm implements Serializable {

    @NotEmpty(message = "ID不能为空")
    private String id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @DecimalMax("150")
    private int age;

    @Email(message = "Email错误")
    private String email;

    @NotEmpty(message = "身份证信息不能为空")
    private String identityCard;

    @Override
    public String toString() {
        return "TestValidatorForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", identityCard='" + identityCard + '\'' +
                '}';
    }


}
