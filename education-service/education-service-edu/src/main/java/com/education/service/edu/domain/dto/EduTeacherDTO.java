package com.education.service.edu.domain.dto;

import com.education.service.base.annotation.SetNull;
import com.education.service.base.annotation.validate.FileNotEmpty;
import com.education.service.base.annotation.validate.FileSize;
import com.education.service.base.annotation.validate.IsImage;
import com.education.service.base.entity.ObjectConvert;
import com.education.service.base.strategy.CreateDataTransferObject;
import com.education.service.base.strategy.UpdateDataTransferObject;
import com.education.service.edu.domain.entity.EduTeacherDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

import static com.education.service.edu.constant.EduConstant.M2_TO_BYTE;

/**
 * @description 教师dto
 * @author 风烛
 * @date 2021-02-17 11:04
 */
@ApiModel("教师入参")
public class EduTeacherDTO extends ObjectConvert<EduTeacherDO> {

    @SetNull(group = CreateDataTransferObject.class)
    @NotBlank(message = "教师 id 不可为空", groups = UpdateDataTransferObject.class)
    @ApiModelProperty("教师 id")
    private String id;

    @NotBlank(message = "教师姓名不可为空", groups = CreateDataTransferObject.class)
    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师简介")
    private String intro;

    @ApiModelProperty(value = "讲师资历,一句话说明讲师")
    private String career;

    @NotBlank(message = "教师头衔不可为空", groups = CreateDataTransferObject.class)
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "讲师头像")
    @IsImage(groups = CreateDataTransferObject.class)
    @FileSize(max = M2_TO_BYTE, message = "图片大小不可超过 2M",
            groups = CreateDataTransferObject.class)
    @FileNotEmpty(groups = CreateDataTransferObject.class)
    private MultipartFile avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "EduTeacherDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", career='" + career + '\'' +
                ", level=" + level +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
