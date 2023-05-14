package Miner.GitHub.model.issue;


import com.fasterxml.jackson.annotation.*;
public class Reactions {
        @JsonProperty("url")
        private String url;
        @JsonProperty("total_count")
        private Integer totalCount;
        @JsonProperty("+1")
        private Integer plus1;
        @JsonProperty("-1")
        private Integer minous1;
        @JsonProperty("laugh")
        private Integer laugh;
        @JsonProperty("hooray")
        private Integer hooray;
        @JsonProperty("confused")
        private Integer confused;
        @JsonProperty("heart")
        private Integer heart;
        @JsonProperty("rocket")
        private Integer rocket;
        @JsonProperty("eyes")
        private Integer eyes;

        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        @JsonProperty("url")
        public void setUrl(String url) {
            this.url = url;
        }

        @JsonProperty("total_count")
        public Integer getTotalCount() {
            return totalCount;
        }

        @JsonProperty("total_count")
        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        @JsonProperty("+1")
        public Integer getPlus1() {
            return plus1;
        }

        @JsonProperty("+1")
        public void setPlus1(Integer plus1) {
            this.plus1 = plus1;
        }

        @JsonProperty("-1")
        public Integer getMinous1() {
            return minous1;
        }

        @JsonProperty("bruh")
        public void setBruh(Integer minous1) {
            this.minous1 = minous1;
        }

        @JsonProperty("laugh")
        public Integer getLaugh() {
            return laugh;
        }

        @JsonProperty("laugh")
        public void setLaugh(Integer laugh) {
            this.laugh = laugh;
        }

        @JsonProperty("hooray")
        public Integer getHooray() {
            return hooray;
        }

        @JsonProperty("hooray")
        public void setHooray(Integer hooray) {
            this.hooray = hooray;
        }

        @JsonProperty("confused")
        public Integer getConfused() {
            return confused;
        }

        @JsonProperty("confused")
        public void setConfused(Integer confused) {
            this.confused = confused;
        }

        @JsonProperty("heart")
        public Integer getHeart() {
            return heart;
        }

        @JsonProperty("heart")
        public void setHeart(Integer heart) {
            this.heart = heart;
        }

        @JsonProperty("rocket")
        public Integer getRocket() {
            return rocket;
        }

        @JsonProperty("rocket")
        public void setRocket(Integer rocket) {
            this.rocket = rocket;
        }

        @JsonProperty("eyes")
        public Integer getEyes() {
            return eyes;
        }

        @JsonProperty("eyes")
        public void setEyes(Integer eyes) {
            this.eyes = eyes;
        }

    }
