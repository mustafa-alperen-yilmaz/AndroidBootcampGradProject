package com.example.gradproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FoodItemCardBinding;
import com.example.gradproject.entity.FoodItem;
import com.example.gradproject.pages.MainFragmentDirections;
import com.example.gradproject.viewmodel.MainPageViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemHolder> {
    private Context context;
    private List<FoodItem> foodItemList;
    private MainPageViewModel viewModel;


    public MenuItemAdapter(Context context, List<FoodItem> foodItemList, MainPageViewModel viewModel) {
        this.context = context;
        this.foodItemList = foodItemList;
        this.viewModel = viewModel;
    }

    public class MenuItemHolder extends RecyclerView.ViewHolder {
        private FoodItemCardBinding binding;


        public MenuItemHolder(@NonNull FoodItemCardBinding binding ) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    @NonNull
    @Override
    public MenuItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodItemCardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.food_item_card,parent,false);
        return new MenuItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemHolder holder, int position) {
        FoodItem food = foodItemList.get(position);
        FoodItemCardBinding bndg = holder.binding;
        bndg.setFoodItem(food);



        bndg.foodName.setText(food.getFoodName());
        bndg.foodPrice.setText(String.valueOf(food.getFoodPrice()));
        String url = "http://kasimadalan.pe.hu/yemekler/resimler/"+food.getFoodPicture();
        Picasso.get().load(url).into(bndg.foodImage);

        bndg.foodCard.setOnClickListener(view ->  {
           MainFragmentDirections.ActionMainToDetail act = MainFragmentDirections.actionMainToDetail(food);
            Navigation.findNavController(view).navigate(act);
        });

    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }


}
