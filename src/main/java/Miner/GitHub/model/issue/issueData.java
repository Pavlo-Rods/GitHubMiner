package Miner.GitHub.model.issue;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

public class issueData {
    @JsonProperty("id")
    private String id;
    @JsonProperty("number")
    private String number;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
    @JsonProperty("description")
    private String description;
    @JsonProperty("state")
    private String state;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("closed_at")
    private String closedAt;
    @JsonProperty("user")
    private User user;
    @JsonProperty("assignee")
    private User assignee;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("labels")
    private List<Label> labels;
    @JsonProperty("reactions")
    private Reactions reactions;
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("number")
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("body")
    public String getBody() {
        return body;
    }
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }
    @JsonProperty("state")
    public String getState() {
        return state;
    }
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }
    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    @JsonProperty("closed_at")
    public String getClosedAt() {
        return closedAt;
    }
    @JsonProperty("closed_at")
    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }
    @JsonProperty("user")
    public User getUser() {
        return user;
    }
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }
    @JsonProperty("assignee")
    public User getAssignee() {
        return assignee;
    }
    @JsonProperty("assignee")
    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }
    @JsonProperty("html_url")
    public void setHtmlUrl(String webUrl) {
        this.htmlUrl = webUrl;
    }
    @JsonProperty("labels")
    public List<Label> getLabels() {
        return labels;
    }
    @JsonProperty("labels")
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
    @JsonProperty("reactions")
    public Reactions getReactions() {
        return reactions;
    }
    @JsonProperty("reactions")
    public void setReactions(Reactions reactions) {
        this.reactions = reactions;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(",\n");
        sb.append("title");
        sb.append('=');
//sb.append(((this.title == null)?"<null>":this.title));
        sb.append(",\n");
        sb.append("description");
        sb.append('=');
//sb.append(((this.description ==null)?"<null>":this.description));
        sb.append(",\n");
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(",\n");
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(",\n");
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(",\n");
        sb.append("closedAt");
        sb.append('=');
        sb.append(((this.closedAt == null)?"<null>":this.closedAt));
        sb.append(",\n");
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(",\n");
        sb.append("assignee");
        sb.append('=');
        sb.append(((this.assignee == null)?"<null>":this.assignee));
        sb.append(",\n");
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}

