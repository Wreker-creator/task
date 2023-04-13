var _viewModel1 : CropsViewModel by lazy{
        val notesRepository = Repository(CropsDatabase.getDatabase(this))
        val viewModelProviderFactory = CropViewModelFactory(notesRepository)
        return ViewModelProvider(this, viewModelProviderFactory).get(CropsViewModel::class.java)
    }