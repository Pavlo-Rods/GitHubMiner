package Miner.GitHub.model.comment;

import Miner.GitHub.model.Usuario;

public class Comment {


    private String id;
    private String body;
    private Usuario author;
    private String created_at;
    private String updated_at;

    public Comment(String id, String body, String created_at, String updated_at) {
        this.id = id;
        this.body = body;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Comment ofFormat(CommentSearch n){
        return new Comment(n.getId().toString(), n.getBody(),
                n.getCreatedAt(), n.getUpdatedAt());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Usuario getAuthor() {
        return author;
    }

    public void setAuthor(Usuario author) {
        this.author = author;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
