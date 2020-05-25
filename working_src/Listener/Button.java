package Listener;
public class Button {
    private String title;
    private OnClickListener onClickListener;

    //constructor for button class.
    public Button(String title){

        this.title = title;

    }

    public void setOnClickListener(OnClickListener onClickListener){

        this.onClickListener = onClickListener;

    }

    public void onClick(){

        this.onClickListener.onClick(this.title);

    }

    //interface for any click listeners
    public interface OnClickListener{

        void onClick(String name);

    }



}
