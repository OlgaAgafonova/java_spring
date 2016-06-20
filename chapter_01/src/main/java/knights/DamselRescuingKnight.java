package knights;

public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        //tightly coupled to RescueDamselQuest
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
