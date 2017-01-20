package scrath.techie.chat.adapter;

import android.view.View;

/**
 * Created by TUSHAR-AMIT on 1/18/2017.
 */

public interface ClickListenerChatFirebase {
    /**
     * Quando houver click na imagem do chat
     * @param view
     * @param position
     */
    void clickImageChat(View view, int position, String nameUser, String urlPhotoUser, String urlPhotoClick);

    /**
     * Quando houver click na imagem de mapa
     * @param view
     * @param position
     */
    void clickImageMapChat(View view, int position,String latitude,String longitude);
}
