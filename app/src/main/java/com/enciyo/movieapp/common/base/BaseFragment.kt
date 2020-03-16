package com.enciyo.movieapp.common.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.enciyo.movieapp.common.MyDataBindingComponents
import com.enciyo.movieapp.presentation.MainActivityViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass


abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModelClass : ViewModel>(
    @LayoutRes private val mResourceID: Int,
    classy: KClass<ViewModelClass>
) : Fragment(mResourceID) {


    val mBinding
        get() = if (mView!=null) mView!! else throw IllegalStateException()

    private var mView: ViewBinding? = null
    val mViewModel: ViewModelClass by viewModel(classy)
    val mActivityViewModel: MainActivityViewModel by activityViewModels()
    private val mCompositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = DataBindingUtil.bind<ViewBinding>(view, MyDataBindingComponents())
        mView?.lifecycleOwner = viewLifecycleOwner
    }

    fun Disposable?.track() {
        this?.let(mCompositeDisposable::add)
    }

    override fun onDestroyView() {
        mCompositeDisposable.clear()
        super.onDestroyView()
    }

}