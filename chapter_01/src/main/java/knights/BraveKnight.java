package knights;

public class BraveKnight implements Knight {

    private Quest quest;

    //Quest is injected
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
