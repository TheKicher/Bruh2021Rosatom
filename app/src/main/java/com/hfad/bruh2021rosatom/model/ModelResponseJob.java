package com.hfad.bruh2021rosatom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ModelResponseJob {

    @SerializedName("jobResponses")
    @Expose
    private List<JobResponse> jobResponses = null;

    public List<JobResponse> getJobResponses() {
        return jobResponses;
    }

    public void setJobResponses(List<JobResponse> jobResponses) {
        this.jobResponses = jobResponses;
    }


    public static class JobResponse {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("job")
        @Expose
        private Job job;
        @SerializedName("letter")
        @Expose
        private String letter;
        @SerializedName("status")
        @Expose
        private String status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Job getJob() {
            return job;
        }

        public void setJob(Job job) {
            this.job = job;
        }

        public String getLetter() {
            return letter;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


        public class Job {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("positionName")
            @Expose
            private String positionName;
            @SerializedName("organization")
            @Expose
            private Organization organization;
            @SerializedName("jobExperience")
            @Expose
            private String jobExperience;
            @SerializedName("jobAttendanceType")
            @Expose
            private String jobAttendanceType;
            @SerializedName("minPayment")
            @Expose
            private Integer minPayment;
            @SerializedName("maxPayment")
            @Expose
            private Integer maxPayment;

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

            public String getJobAttendanceType() {
                return jobAttendanceType;
            }

            public void setJobAttendanceType(String jobAttendanceType) {
                this.jobAttendanceType = jobAttendanceType;
            }

            public String getJobExperience() {
                return jobExperience;
            }

            public void setJobExperience(String jobExperience) {
                this.jobExperience = jobExperience;
            }

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

            public Organization getOrganization() {
                return organization;
            }

            public void setOrganization(Organization organization) {
                this.organization = organization;
            }

            public class Organization {

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
                @SerializedName("city")
                @Expose
                private String city;

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

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

            }

        }

    }
}