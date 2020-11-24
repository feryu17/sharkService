import java.util.List;

public class GeneralModel {


    private String listName;

    private List<VideoModel> videoItem;

    public GeneralModel(String listName, List<VideoModel> videoItem) {
        this.listName = listName;
        this.videoItem = videoItem;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<VideoModel> getVideoItem() {
        return videoItem;
    }

    public void setVideoItem(List<VideoModel> videoItem) {
        this.videoItem = videoItem;
    }
}
