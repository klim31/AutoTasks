package entities;

public class PriorityBO {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        private String title;
        private String description;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public PriorityBO build() {
            PriorityBO priorityBO = new PriorityBO();
            priorityBO.title = this.title;
            priorityBO.description = this.description;
            return priorityBO;
        }


    }

    private PriorityBO() {
    }

}
