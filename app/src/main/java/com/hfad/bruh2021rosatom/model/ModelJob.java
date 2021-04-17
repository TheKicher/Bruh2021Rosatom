package com.hfad.bruh2021rosatom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelJob {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("positionName")
    @Expose
    private String positionName;
    @SerializedName("minPayment")
    @Expose
    private Integer minPayment;
    @SerializedName("maxPayment")
    @Expose
    private Integer maxPayment;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("jobAttendanceType")
    @Expose
    private String jobAttendanceType;
    @SerializedName("jobEmploymentType")
    @Expose
    private String jobEmploymentType;
    @SerializedName("organization")
    @Expose
    private Organization organization;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("jobExperience")
    @Expose
    private String jobExperience;
    @SerializedName("requiredSkills")
    @Expose
    private List<RequiredSkill> requiredSkills = null;
    @SerializedName("improvedSkills")
    @Expose
    private List<Object> improvedSkills = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(Integer minPayment) {
        this.minPayment = minPayment;
    }

    public Integer getMaxPayment() {
        return maxPayment;
    }

    public void setMaxPayment(Integer maxPayment) {
        this.maxPayment = maxPayment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobAttendanceType() {
        return jobAttendanceType;
    }

    public void setJobAttendanceType(String jobAttendanceType) {
        this.jobAttendanceType = jobAttendanceType;
    }

    public String getJobEmploymentType() {
        return jobEmploymentType;
    }

    public void setJobEmploymentType(String jobEmploymentType) {
        this.jobEmploymentType = jobEmploymentType;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    public List<RequiredSkill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<RequiredSkill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public List<Object> getImprovedSkills() {
        return improvedSkills;
    }

    public void setImprovedSkills(List<Object> improvedSkills) {
        this.improvedSkills = improvedSkills;
    }

    public static class Organization {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("rating")
        @Expose
        private Float rating;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("telegram")
        @Expose
        private String telegram;
        @SerializedName("agentName")
        @Expose
        private String agentName;
        @SerializedName("agentEmail")
        @Expose
        private String agentEmail;
        @SerializedName("city")
        @Expose
        private String city;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Float getRating() {
            return rating;
        }

        public void setRating(Float rating) {
            this.rating = rating;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getTelegram() {
            return telegram;
        }

        public void setTelegram(String telegram) {
            this.telegram = telegram;
        }

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }

        public String getAgentEmail() {
            return agentEmail;
        }

        public void setAgentEmail(String agentEmail) {
            this.agentEmail = agentEmail;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

    }

    public static class RequiredSkill {

        @SerializedName("name")
        @Expose
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}

