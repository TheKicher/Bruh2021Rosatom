package com.hfad.bruh2021rosatom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelResponseInternship {

    @SerializedName("internshipResponses")
    @Expose
    private List<InternshipResponse> internshipResponses = null;

    public List<InternshipResponse> getInternshipResponses() {
        return internshipResponses;
    }

    public void setInternshipResponses(List<InternshipResponse> internshipResponses) {
        this.internshipResponses = internshipResponses;
    }

    public static class InternshipResponse {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("internship")
        @Expose
        private Internship internship;
        @SerializedName("createdAt")
        @Expose
        private Integer createdAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Internship getInternship() {
            return internship;
        }

        public void setInternship(Internship internship) {
            this.internship = internship;
        }

        public Integer getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Integer createdAt) {
            this.createdAt = createdAt;
        }


        public static class Internship {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("organization")
            @Expose
            private Organization organization;
            @SerializedName("tags")
            @Expose
            private List<Object> tags = null;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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
                private Double rating;

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

                public Double getRating() {
                    return rating;
                }

                public void setRating(Double rating) {
                    this.rating = rating;
                }

            }

        }

    }


}
