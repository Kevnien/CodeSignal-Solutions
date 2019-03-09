// Elections are in progress!

// Given an array of the numbers of votes given to each of the candidates so far, and an integer k equal to the number of voters who haven't cast their vote yet, find the number of candidates who still have a chance to win the election.

// The winner of the election must secure strictly more votes than any other candidate. If two or more candidates receive the same (maximum) number of votes, assume there is no winner at all.

import java.util.Arrays;
class ElectionsWinners{
    public static int electionsWinners(int[] votes, int k){
        class Leader{
            public int votes;
            public boolean tied;
            Leader(int votes, boolean tied){
                this.votes = votes;
                this.tied = tied;
            }
        }
        Leader leader = new Leader(votes[0], false);
        for(int i=1; i<votes.length; i++){
            if(votes[i]>leader.votes){
                leader = new Leader(votes[i], false);
            }else if(votes[i]==leader.votes){
                leader.tied = true;
            }
        }
        int count = 0;
        for(int i=0; i<votes.length; i++){
            if(votes[i]+k > leader.votes){
                count++;
            }
        }
        if(count==0 && !leader.tied){
            return 1;
        }
        return count;
    }

    public static void main(String[] args){
        int[][][] inputs = {
            {
                {2, 3, 5, 2},
                {3}
            },
            {
                {1, 3, 3, 1, 1},
                {0}
            },
            {
                {5, 1, 3, 4, 1},
                {0}
            },
            {
                {1, 1, 1, 1},
                {1}
            },
            {
                {1, 1, 1, 1},
                {0}
            },
            {
                {3, 1, 1, 3, 1},
                {2}
            }
        };
        int[] expectedOutputs = {
            2,
            0,
            1,
            4,
            0,
            2
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "electionWinners("+
                Arrays.toString(inputs[i][0])+", "+
                inputs[i][1][0]+"):\n"+
                electionsWinners(inputs[i][0], inputs[i][1][0])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}