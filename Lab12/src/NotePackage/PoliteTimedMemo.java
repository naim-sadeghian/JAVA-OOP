package NotePackage;

public class PoliteTimedMemo extends TimedMemo {
    protected final String DEFAULT_GREETING ;
    protected final String DEFAULT_CLOSING ;

    // PoliteTimedMemo(String name, String body, String from, String to) {
    //     super(name, body, from, to);
    //     this.today = java.time.LocalDate.now( ).toString();
    //     this.DEFAULT_GREETING = "Dear";
    //     this.DEFAULT_CLOSING = "Yours truly,";
    // }
    private PoliteTimedMemo(Builder builder) {
        super(builder.name, builder.body, builder.from, builder.to);
        this.today = java.time.LocalDate.now( ).toString();
        this.DEFAULT_GREETING = "Dear";
        this.DEFAULT_CLOSING = "Yours truly,";
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //Start with parents string
        sb.append("Date: ").append(today).append("\n"); //Add date on top
        sb.append("Name: ").append(name).append("\n");
        sb.append(DEFAULT_GREETING).append(" ").append(to).append(":\n");
        sb.append(body);
        sb.append(DEFAULT_CLOSING).append("\n");
        sb.append(from).append("\n");
        sb.append("Note# ").append(noteNumber).append("\n");
        sb.append(FOOTER).append("\n");

        return sb.toString();
    }

    public static class Builder {

        private String name;
        private String body;
        private String from;
        private String to;
        
        public Builder(){

        }

        public Builder setName(String name){
            this.name = name;
            return this;
        };
        public Builder setBody(String body){
            this.body = body;
            return this;
        };
        public Builder setFrom(String from){
            this.from = from;
            return this;
        };
        public Builder setTo(String to){
            this.to = to;
            return this;
        };

        public PoliteTimedMemo build(){
            return new PoliteTimedMemo(this);
        }
    }
}

