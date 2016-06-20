package knights;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() {
        //create mock Quest
        Quest mockQuest = mock(Quest.class);
        //Inject mock Quest
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        /* verify that the mock Quest’s embark() method
        was called exactly once*/
        verify(mockQuest, times(1)).embark();
    }
}