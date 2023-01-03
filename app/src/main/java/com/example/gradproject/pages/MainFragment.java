package com.example.gradproject.pages;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gradproject.R;
import com.example.gradproject.adapter.MenuItemAdapter;
import com.example.gradproject.databinding.FragmentMainBinding;
import com.example.gradproject.viewmodel.MainPageViewModel;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private MainPageViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.setHeaderOfToolBar("YEMEKLER");

        binding.rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        viewModel.foodItemList.observe(getViewLifecycleOwner(),foodItemList->{
            MenuItemAdapter adapter  = new MenuItemAdapter(requireContext(),foodItemList,viewModel);
            binding.setFoodAdapter(adapter);
        });
        binding.setMainFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainPageViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.foodGet();
    }
}
