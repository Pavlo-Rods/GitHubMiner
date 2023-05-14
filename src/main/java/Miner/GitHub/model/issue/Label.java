package Miner.GitHub.model.issue;

import com.fasterxml.jackson.annotation.*;

public class Label {
    @JsonProperty("name")
    private String name;
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}
