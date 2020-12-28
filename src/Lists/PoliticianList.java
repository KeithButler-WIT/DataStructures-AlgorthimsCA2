package Lists;

public class PoliticianList {
    public PoliticianNode<P> head,tail;

    public class PoliticianNode<P> {
        // Todo: implement previous variable
        public PoliticianNode<P> next, previous;  //points to next node
        private Politician<P> contents; //stores the actual object in the contents field
//        private CandidateList<C> candidate=new CandidateList<>();

        public Politician<P> getContents() { return contents; }
        public void setContents(Politician<P> c) { contents=c; }

        //Todo: Change to politicianlist
//        public CandidateList<C> getCandidate() {
//            return candidate;
//        }
//
//        //---candidate Methods---//
//
//        //Adds an candidate to the CandidateList
//        public void addCandidate(String id,int width,int depth){
//            candidate.addElement(new Candidate(id,width,depth));
//        }

        // Todo: add fancy methods that do fancy things

    }
}
