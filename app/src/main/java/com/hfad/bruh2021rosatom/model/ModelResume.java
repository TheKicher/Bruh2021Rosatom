package com.hfad.bruh2021rosatom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelResume {

    @SerializedName("userProfile")
    @Expose
    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public static class UserProfile {

        @SerializedName("aboutMe")
        @Expose
        private String aboutMe;
        @SerializedName("haveJobPermission")
        @Expose
        private Boolean haveJobPermission;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("telegram")
        @Expose
        private String telegram;
        @SerializedName("jobExperienses")
        @Expose
        private List<JobExperiense> jobExperienses = null;
        @SerializedName("institute")
        @Expose
        private Institute institute;
        @SerializedName("speciality")
        @Expose
        private Speciality speciality;

        public String getAboutMe() {
            return aboutMe;
        }

        public void setAboutMe(String aboutMe) {
            this.aboutMe = aboutMe;
        }

        public Boolean getHaveJobPermission() {
            return haveJobPermission;
        }

        public void setHaveJobPermission(Boolean haveJobPermission) {
            this.haveJobPermission = haveJobPermission;
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

        public List<JobExperiense> getJobExperienses() {
            return jobExperienses;
        }

        public void setJobExperienses(List<JobExperiense> jobExperienses) {
            this.jobExperienses = jobExperienses;
        }

        public Institute getInstitute() {
            return institute;
        }

        public void setInstitute(Institute institute) {
            this.institute = institute;
        }

        public Speciality getSpeciality() {
            return speciality;
        }

        public void setSpeciality(Speciality speciality) {
            this.speciality = speciality;
        }

        public static class Institute {

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

        public static class JobExperiense {

            @SerializedName("companyName")
            @Expose
            private String companyName;
            @SerializedName("position")
            @Expose
            private String position;
            @SerializedName("jobTimePeriod")
            @Expose
            private String jobTimePeriod;

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getJobTimePeriod() {
                return jobTimePeriod;
            }

            public void setJobTimePeriod(String jobTimePeriod) {
                this.jobTimePeriod = jobTimePeriod;
            }

        }

        public class Speciality {

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

}



