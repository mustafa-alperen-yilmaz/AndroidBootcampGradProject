package com.example.gradproject.pages;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gradproject.R;
import com.example.gradproject.databinding.FragmentItemDetailBinding;
import com.example.gradproject.entity.FoodItem;
import com.example.gradproject.viewmodel.ItemDetailViewModel;
import com.andremion.counterfab.CounterFab;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ItemDetailFragment extends Fragment {
    private FragmentItemDetailBinding binding;
    private ItemDetailViewModel viewModel;
    CounterFab fabButtonCounter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_item_detail,container, false);

        ItemDetailFragmentArgs bundle = ItemDetailFragmentArgs.fromBundle(getArguments());
        FoodItem foodGetting = bundle.getFood();
        binding.setFoodItem(foodGetting);
        binding.setFoodDetailFragment(this);

        String prc = String.valueOf(foodGetting.getFoodPrice());
        binding.foodPriceOnDetail.setText(prc);
        String url = "http://kasimadalan.pe.hu/yemekler/resimler/"+foodGetting.getFoodPicture();
        Picasso.get().load(url).into(binding.foodImageOnDetail);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ItemDetailViewModel.class);
    }
    public void goCardClicked(View view){
        Navigation.findNavController(view).navigate(R.id.actionDetailToShoppingCart);
    }

}