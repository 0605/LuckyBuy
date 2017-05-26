package com.luckybuy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.PopupWindow;

/**
 * All rights Reserved, Designed By GeofferySun 
 * @Title: 	PopupWindow_Share.java
 * @Package sun.geoffery.uploadpic 
 * @Description:�ӵײ������򻬳�ѡ��˵��򴰿�
 * @author:	Zhipeng.S
 * @date:	2015��1��15�� ����1:21:01 
 * @version	V1.0
 */
public class PopupWindow_Share extends PopupWindow {

	private RelativeLayout share_facebook, share_messenger, share_twitter, share_copy;
	private Button cancelBtn;
	private View mMenuView;

	@SuppressLint("InflateParams")
	public PopupWindow_Share(Context context, OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.commodity_detail_pop_share, null);
		share_facebook = (RelativeLayout) mMenuView.findViewById(R.id.share_facebook_rl);
		share_messenger = (RelativeLayout) mMenuView.findViewById(R.id.share_messenger_rl);
		share_twitter = (RelativeLayout) mMenuView.findViewById(R.id.share_twitter_rl);
		share_copy = (RelativeLayout) mMenuView.findViewById(R.id.share_copy_rl);
		cancelBtn = (Button) mMenuView.findViewById(R.id.share_cancel_btn);
		// ���ð�ť����
		cancelBtn.setOnClickListener(itemsOnClick);
		share_messenger.setOnClickListener(itemsOnClick);
		share_facebook.setOnClickListener(itemsOnClick);
		share_twitter.setOnClickListener(itemsOnClick);
		share_copy.setOnClickListener(itemsOnClick);
		
		// ����SelectPicPopupWindow��View
		this.setContentView(mMenuView);
		// ����SelectPicPopupWindow��������Ŀ�
		this.setWidth(LayoutParams.MATCH_PARENT);
		// ����SelectPicPopupWindow��������ĸ�
		this.setHeight(LayoutParams.WRAP_CONTENT);
		// ����SelectPicPopupWindow��������ɵ��
		this.setFocusable(true);
		// ����SelectPicPopupWindow�������嶯��Ч��
		this.setAnimationStyle(R.style.PopupAnimation);
		// ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0x80000000);
		// ����SelectPicPopupWindow��������ı���
		this.setBackgroundDrawable(dw);
		// mMenuView���OnTouchListener�����жϻ�ȡ����λ�������ѡ������������ٵ�����
		mMenuView.setOnTouchListener(new OnTouchListener() {

			@Override
			@SuppressLint("ClickableViewAccessibility")
			public boolean onTouch(View v, MotionEvent event) {

				int height = mMenuView.findViewById(R.id.detail_share_pop_rl).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				return true;
			}
		});

	}

}
